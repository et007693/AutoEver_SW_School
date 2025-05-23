import "./App.css";

import Members from "./0523/Members";
import Say from "./0523/Say";
import EventInput from "./0523/EventInput";
import TableMap from "./0523/Table";
import NameCard from "./0523/NameCard";
import Info from "./0523/Info";
import Clock from "./0523/Clock";
import Counter from "./0523/Counter";

function App() {
  return (
    <>
      <h1>App.js입니다.</h1>
      {/* <Members name="안유진" age={23} addr="대전" isAdult={true} />
      <Members name="장원영" age={22} addr="대전" isAdult={true} />
      <Members name="이서" age={19} addr="대전" isAdult={false} /> */}
      {/* <Say /> */}
      {/* <EventInput /> */}
      {/* <TableMap /> */}
      {/* <NameCard /> */}
      {/* <Info /> */}
      {/* <Clock /> */}
      <Counter />
    </>
  );
}

export default App;
