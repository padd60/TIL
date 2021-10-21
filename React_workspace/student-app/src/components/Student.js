import React, { Component } from 'react';

class Student extends Component {
  state = {
    id: '',
    name: '',
    address: '',
  };
  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };
  initiateText = (text) => {
    if (text === '') return '_____';
    return text;
  };
  render() {
    return (
      <form>
        <input
          placeholder="아이디"
          value={this.state.id}
          name="id"
          onChange={this.handleChange}
        ></input>
        <input
          placeholder="이름"
          value={this.state.name}
          name="name"
          onChange={this.handleChange}
        ></input>
        <input
          placeholder="주소"
          value={this.state.address}
          name="address"
          onChange={this.handleChange}
        ></input>
        <div>
          <span>학생의 아이디는 </span>
          {this.initiateText(this.state.id)}
          <span>, 이름은 </span>
          {this.initiateText(this.state.name)}
          <span>, 주소는 </span>
          {this.initiateText(this.state.address)}
          <span>입니다.</span>
        </div>
      </form>
    );
  }
}

export default Student;
