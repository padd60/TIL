// import React, { Component } from 'react';
import React from 'react';

// class MyName extends Component {
//   static defaultProps = {
//     name: '기본이름',
//   }; props 설정 없을 때 기본값으로 넣어주는 용도로 사용
//   render() {
//     return (
//       <div>
//         안녕하세요! 제 이름은 <b>{this.props.name}</b>입니다.
//       </div>
//     );
//   }
// }

const MyName = ({ name }) => {
  return (
    <div>
      안녕하세요! 제 이름은 <b>{name}</b>입니다.
    </div>
  );
};

export default MyName;
