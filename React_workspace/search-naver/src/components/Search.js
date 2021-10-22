import React, { Component } from 'react';

class Search extends Component {
  default_URL = 'https://search.naver.com/search.naver?query=';

  state = {
    value: '기본값',
    url: '기본주소',
  };

  handleChange = (e) => {
    const value = e.target.value;

    this.setState({
      value: value,
      url: this.default_URL + value,
    });
  };

  handleClick = (e) => {
    e.preventDefault();

    const { value, url } = this.state;

    url === this.default_URL || url === '기본주소'
      ? alert('검색어를 입력해주세요!')
      : window.open(url);

    console.log(value);
    console.log(url);
  };

  render() {
    return (
      <div>
        <h1>네이버 검색기</h1>
        <form>
          <input
            placeholder="검색어를 입력하세요.."
            onChange={this.handleChange}
          />
          <button onClick={this.handleClick}>검색</button>
        </form>
      </div>
    );
  }
}

export default Search;
