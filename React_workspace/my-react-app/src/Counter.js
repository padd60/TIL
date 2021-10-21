import React, { Component } from 'react';

class Counter extends Component {
  state = {
    number: 0,
  };

  handleIncrease = () => {
    this.setState({
      number: this.state.number + 1,
    });
  };
  handleDecrease = () => {
    this.setState({
      number: this.state.number - 1,
    });
  };
  shouldComponentUpdate(nextProps, nextState) {
    // 5의 배수라면 리렌더링 하지 않음
    if (nextState.number === 0) return true;
    if (nextState.number % 5 === 0) return false;
    return true;
  }
  render() {
    return (
      <div>
        <h1>카운터</h1>
        <div>값: {this.state.number}</div>
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
      </div>
    );
  }
}

export default Counter;
