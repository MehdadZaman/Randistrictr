import { useState } from 'react';
import './index.css';

import SidebarOptions from '../sidebarOptions';

const Sidebar = ({ map, selectedState }) => {
  const [expanded, setExpanded] = useState(false);
  console.log(selectedState);
  return (
    <>
      <aside className='sidebar' style={{ width: expanded ? '350px' : '15px' }}>
        <div style={{ display: expanded ? 'block' : 'none', padding: 10 }}>
          <div style={{ textAlign: "center" }}>
            {selectedState ? <h1>Filter for {selectedState} districts</h1> : <h1 style={{ fontSize: "3vh", transform: "translateY(350%)" }}>Please select a state to continue</h1>}
            {selectedState ? <SidebarOptions /> : <h1></h1>}
          </div>
        </div>
      </aside>
      <button
        className='toggleButton'
        style={{ left: expanded ? '350px' : '15px', transition: 'left 0.5s' }}
        onClick={() => setExpanded(!expanded)}
      >
        {expanded ? '<' : '>'}
      </button>
    </>
  );
};

export default Sidebar;
