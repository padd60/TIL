import React, { Component } from 'react';

class AjaxTest3 extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      item: {},
      id: '',
    };
  }

  handleChange = (e) => {
    this.setState({
      id: e.target.value,
    });
    console.log(this.state.id);
  };

  handleSubmit = (e) => {
    e.preventDefault();
    console.log('handleSubmit');
    if (!this.state.id) {
      alert('id를 입력하세요');
      return;
    }

    fetch('http://pjs.dothome.co.kr/ajaxDB3.php?id=' + this.state.id)
      .then((res) => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            item: result,
          });
          console.log(result);
        },
        (error) => {
          TouchList.setState({
            isLoaded: true,
            error,
          });
        }
      );
  };

  render() {
    const { item } = this.state;
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <input type="text" name="id" onChange={this.handleChange}></input>
          <input type="submit" value="search"></input>
        </form>
        <div>
          <h1>{item.id}</h1>
          <h1>{item.name}</h1>
          <h1>{item.address}</h1>
        </div>
      </div>
    );
  }
}

export default AjaxTest3;
