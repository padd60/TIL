import MyName from './MyName';
import Counter from './Counter';
import './App.css';

function App() {
  return (
    <div>
      <MyName name="리액트" />
      <Counter />
    </div>
  );
}

export default App; // 밖에서 접근하기 위해서 적는 코드 자바의 public과 비슷
