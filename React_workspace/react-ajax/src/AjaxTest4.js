import React, { Component } from 'react';

class AjaxTest4 extends Component {
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

    fetch('http://padd60.ivyro.net/ajaxDB3.php?id=' + this.state.id)
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
          <table>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <tr>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.address}</td>
            </tr>
          </table>
        </div>
      </div>
    );
  }
}

export default AjaxTest4;
