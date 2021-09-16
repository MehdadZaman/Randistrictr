import { Button } from '@chakra-ui/button';
import { useState } from 'react';
import './sidebar.css';
import StateSelect from './StatesSelect';

const Sidebar = ({ map }) => {
  const [expanded, setExpanded] = useState(false);
  return (
    <>
      <aside className='sidebar' style={{ width: expanded ? '350px' : '15px' }}>
        {expanded ? (
          <div>
            <StateSelect map={map} />
          </div>
        ) : null}
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
