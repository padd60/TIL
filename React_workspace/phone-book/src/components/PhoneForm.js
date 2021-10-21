import React, { Component } from 'react';

class PhoneForm extends Component {
  state = {
    name: '',
    phone: '',
  };

  // handleChange = (e) => {
  //   this.setState({
  //     name: e.target.value, 한개의 인풋태그만 적용됨
  //   });
  // };

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value, // 중요한 개념
    });
  };

  render() {
    return (
      <form>
        <input
          placeholder="이름"
          value={this.state.name}
          onChange={this.handleChange}
          name="name" // handleChange 메서드에서 e.target.name에 의해 불러지는 값
        ></input>
        <input
          placeholder="전화번호"
          value={this.state.phone}
          onChange={this.handleChange}
          name="phone" // handleChange 메서드에서 e.target.name에 의해 불러지는 값
        ></input>
        <div>
          {this.state.name} {this.state.phone}
        </div>
      </form>
    );
  }
}

export default PhoneForm;
