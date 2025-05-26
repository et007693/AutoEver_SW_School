import "./App.css";

import Members from "./0523/Members";
import Say from "./0523/Say";
import EventInput from "./0523/EventInput";
import TableMap from "./0523/Table";
import NameCard from "./0523/NameCard";
import Info from "./0523/Info";
import Clock from "./0523/Clock";
import Counter from "./0523/Counter";

import RefCnt from "./0526/RefCnt";
import CreateRef from "./0526/CreateRef";
import StyledCom from "./0526/StyledCom";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Profile from "./pages/Profile";
import Layout from "./pages/Layout";

import NewsList from "./prac/NewsList";

function App() {
  return (
    <>
      {/* <h1>App.js입니다.</h1> */}
      {/* <Members name="안유진" age={23} addr="대전" isAdult={true} />
      <Members name="장원영" age={22} addr="대전" isAdult={true} />
      <Members name="이서" age={19} addr="대전" isAdult={false} /> */}
      {/* <Say /> */}
      {/* <EventInput /> */}
      {/* <TableMap /> */}
      {/* <NameCard /> */}
      {/* <Info /> */}
      {/* <Clock /> */}
      {/* <Counter /> */}

      {/* <RefCnt /> */}
      {/* <CreateRef /> */}
      {/* <StyledCom /> */}
      {/* <Router>
        <Routes>
          <Route element={<Layout />}>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/profiles/:username" element={<Profile />} />
          </Route>
        </Routes>
      </Router> */}

      <Router>
        <Routes>
          <Route path="/" element={<NewsList />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
