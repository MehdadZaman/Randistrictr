import { useState } from 'react';
import './index.css';

const Sidebar = ({ map, expanded, onToggle, position, children }) => {
  let positionStyle = { top: 10, bottom: 10 };
  let buttonStyle = {
    left: expanded ? '350px' : '15px',
    transition: 'left 0.5s',
    borderRadius: '0 4px 4px 0',
  };
  let expandIcon = '<';
  let collapseIcon = '>';
  if (position === 'right') {
    positionStyle = {
      ...positionStyle,
      right: 0,
    };
    buttonStyle = {
      right: expanded ? '350px' : '15px',
      transition: 'right 0.5s',
      borderRadius: '4px 0 0 4px',
    };
    expandIcon = '>';
    collapseIcon = '<';
  }
  return (
    <>
      <aside
        className='sidebar'
        style={{ ...positionStyle, width: expanded ? '350px' : '15px' }}
      >
        <div style={{ display: expanded ? 'block' : 'none', padding: 10 }}>
          {children}
        </div>
      </aside>
      <button className='toggleButton' style={buttonStyle} onClick={onToggle}>
        {expanded ? expandIcon : collapseIcon}
      </button>
    </>
  );
};

export default Sidebar;
