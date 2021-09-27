import React, { useState } from 'react';
import ReactTooltip from 'react-tooltip';
import { PieChart as ReactMinimalPieChart } from 'react-minimal-pie-chart';

function makeTooltipContent(entry) {
  return `${entry.tooltip}: ${entry.value}%`;
}

function PieChart(props) {
  const [selected, setSelected] = useState();
  const [hovered, setHovered] = useState(undefined);

  const data = props.data.map((entry, i) => {
    if (hovered === i) {
      return {
        ...entry,
        color: '#ff99ff',
        tooltip: entry.title,
      };
    }
    return { ...entry, tooltip: entry.title };
  });

  return (
    <div data-tip='' data-for='chart'>
      <ReactMinimalPieChart
        style={{
          fontFamily:
            '"Nunito Sans", -apple-system, Helvetica, Arial, sans-serif',
          fontSize: '8px',
        }}
        data={data}
        radius={35}
        lineWidth={60}
        segmentsStyle={{ transition: 'stroke .3s', cursor: 'pointer' }}
        segmentsShift={(index) => (index === selected ? 6 : 1)}
        animate
        label={({ dataEntry }) =>
          Math.round(dataEntry.percentage * 100) / 100 + '%'
        }
        // labelPosition={100 - lineWidth / 2}
        // labelStyle={{
        //   fill: '#fff',
        //   opacity: 0.75,
        //   pointerEvents: 'none',
        // }}
        labelStyle={(index) => ({
          fill: data[index].color,
          fontSize: '5px',
          fontFamily: 'sans-serif',
        })}
        labelPosition={112}
        onClick={(_, index) => {
          setSelected(index === selected ? undefined : index);
        }}
        onMouseOver={(_, index) => {
          setHovered(index);
        }}
        onMouseOut={() => {
          setHovered(undefined);
        }}
      />
      <ReactTooltip
        id='chart'
        getContent={() =>
          typeof hovered === 'number' ? makeTooltipContent(data[hovered]) : null
        }
      />
    </div>
  );
}

export default PieChart;
