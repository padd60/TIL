import React, { Component } from 'react';
import PhoneInfo from './PhoneInfo';

class PhoneInfoList extends Component {
  static defaultProps = {
    list: [],
    onRemove: () => console.warn('onRemove not defined'),
    onUpdate: () => console.warn('onUpdate not defined'),
  };

  shouldComponentUpdate(nextProps, nextState) {
    // 프로퍼티 값이 변경이 되면 다시 렌더링
    return nextProps.data !== this.props.data;
  }

  render() {
    console.log('render PhoneInfoList');
    const { data, onRemove, onUpdate } = this.props;
    const list = data.map((info) => (
      <PhoneInfo
        key={info.id}
        info={info}
        onRemove={onRemove}
        onUpdate={onUpdate}
      />
    ));
    return <div>{list}</div>;
  }
}

export default PhoneInfoList;
