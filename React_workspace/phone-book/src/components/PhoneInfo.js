import React, { Component } from 'react';

class PhoneInfo extends Component {
  static defaultProps = {
    info: {
      name: '이름',
      phone: '010-0000-0000',
      id: 0,
    },
  };

  state = {
    editing: false,
    name: '',
    phone: '',
  };

  handleRemove = () => {
    const { info, onRemove } = this.props;
    onRemove(info.id);
  };

  handleToggleEdit = () => {
    const { editing } = this.state;
    this.setState({ editing: !editing });
  };

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({
      [name]: value,
    });
  };

  componentDidUpdate(prevProps, prevState) {
    const { info, onUpdate } = this.props;
    if (!prevState.editing && this.state.editing) {
      this.setState({
        name: info.name,
        phone: info.phone,
      });
    }

    if (prevState.editing && !this.state.editing) {
      onUpdate(info.id, { name: this.state.name, phone: this.state.phone });
    }
  }

  render() {
    const style = {
      border: '1px solid black',
      padding: '8px',
      margin: '8px',
    };

    //수정모드
    const { editing } = this.state;

    if (editing) {
      return (
        <div style={style}>
          <div>
            <input
              placeholder="이름"
              value={this.state.name}
              onChange={this.handleChange}
              name="name"
            ></input>
          </div>
          <div>
            <input
              placeholder="전화번호"
              value={this.state.phone}
              onChange={this.handleChange}
              name="phone"
            ></input>
          </div>
          <button onClick={this.handleToggleEdit}>적용</button>
          <button onClick={this.handleRemove}>삭제</button>
        </div>
      );
    }

    // 일반모드
    const { name, phone } = this.props.info;

    return (
      <div style={style}>
        <div>
          <b>{name}</b>
        </div>
        <div>{phone}</div>
        <button onClick={this.handleToggleEdit}>수정</button>
        <button onClick={this.handleRemove}>삭제</button>
      </div>
    );
  }
}

export default PhoneInfo;
