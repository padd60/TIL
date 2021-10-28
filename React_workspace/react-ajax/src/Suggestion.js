import React, { Component } from 'react';
import './Suggestion.css';
class Suggestion extends Component {
  state = {
    items: [],
    keyword: '',
    show : true
  }
  handleChange = (e) => {
    console.log(e.target.value);  
    if(!e.target.value){
      this.setState({
        items: [],
        keyword: '',
        show : false
      })
      return;
    }
    this.setState({
      [e.target.name]: e.target.value,
      show:true
    })
   
    console.log("http://pjs.dothome.co.kr/suggestionJson.php?q="+e.target.value);

    fetch("http://pjs.dothome.co.kr/suggestionJson.php?q="+e.target.value)
    .then(res=>res.json())
    .then(
      (result)=>{
        this.setState({
          isLoaded: true,
          items: result
        });
      },
      (error)=>{
        this.setState({
          isLoaded:true,
          error
        });
      }
    );
  }

  handleClick=(e)=>{
    console.log(e.target.value);
    this.setState({
      keyword: e.target.value,
      show: false
    })
  };
  
  render() {
    const style1 = {
      border:'10px solid green',
      padding:'15px',
      fontSize:'20px'
    }
    const style2 = {
      border: 'none',
      cursor: 'pointer',
      backgroundColor: 'white',
      fontSize: '20px'          
    };
 
    return (        
      <div>   
        <h1>네이버 검색어 자동완성기능 데모</h1>      
        <form>
            <input autoComplete='off'style={style1} type='text' value={this.state.keyword} name='keyword' onChange={this.handleChange}></input>
        </form>
        <ul style={{display: this.state.show ? 'block' : 'none', listStyle: 'none'}}>
          {this.state.items.map(item => (
            <li key={item.id}>
              <input style={style2} type='button' onClick={this.handleClick} value={item.keyword}/>
            </li>              
          ))}
        </ul>
      </div>
    );
  }
}

export default Suggestion;