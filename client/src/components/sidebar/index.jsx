import { useState } from 'react';
import './index.css';

const Sidebar = ({ map }) => {
  const [expanded, setExpanded] = useState(false);
  return (
    <>
      <aside className='sidebar' style={{ width: expanded ? '350px' : '15px' }}>
        <div style={{ display: expanded ? 'block' : 'none', padding: 10 }}>
          <span>Select Something</span>
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