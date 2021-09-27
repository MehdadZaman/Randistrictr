import { useState } from 'react';
import './index.css';

const Sidebar = ({
  map,
  expanded,
  onToggle,
  position,
  width = 350,
  children,
}) => {
  let positionStyle = { top: 10, bottom: 10 };
  let buttonStyle = {
    left: expanded ? width : '15px',
    transition: 'left 0.5s',
    borderRadius: '0 4px 4px 0',
  };
  let expandIcon = '<';
  let collapseIcon = '>';
  if (position === 'right') {
    positionStyle = {
      ...positionStyle,
      bottom: 100,
      right: 0,
    };
    buttonStyle = {
      right: expanded ? width : '15px',
      transition: 'right 0.5s',
      borderRadius: '4px 0 0 4px',
      top: 'calc(40vh)',
    };
    expandIcon = '>';
    collapseIcon = '<';
  }
  return (
    <>
      <aside
        className='sidebar'
        style={{ ...positionStyle, width: expanded ? width : '15px' }}
      >
        <div className='sidebarWrapper'>
          <div style={{ display: expanded ? 'block' : 'none', padding: 10 }}>
            {children}
          </div>
        </div>
      </aside>
      <button className='toggleButton' style={buttonStyle} onClick={onToggle}>
        {expanded ? expandIcon : collapseIcon}
      </button>
    </>
  );
};

export default Sidebar;
