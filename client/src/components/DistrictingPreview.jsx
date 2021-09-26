import { useRef, React } from 'react';
import DistrictingCardList from './DistrictingCardList';

const DistrictingPreview = ({ onSelect }) => {
  const cards = [
    {
      imageUrl:
        'https://filipinotimes.net/wp-content/uploads/2019/08/moth-balls.jpg',
      imageAlt: 'Maryland',
      title: 'Random Districting 1',
      description:
        'This districting minimized the number of majority minority districts.',
      congressionalDistricts: 8,
      votingDistricts: '8,654',
      minorityMajorityDistrict: 3,
      threshold: 50,
      maxPopulationRange: 137429,
      populationScore: 86,
      efficiencyGapMeasure: 0.44,
      polsbyPopperScore: 0.42,
    },
    {
      imageUrl:
        'https://pbs.twimg.com/profile_images/1070717297088704512/6YlQwIk-_400x400.jpg',
      imageAlt: 'Maryland',
      title: 'Random Districting 2',
      description:
        'This districting minimized the number of majority minority districts.',
      congressionalDistricts: 8,
      votingDistricts: '8,654',
      minorityMajorityDistrict: 3,
      threshold: 50,
      maxPopulationRange: 137429,
      populationScore: 86,
      efficiencyGapMeasure: 0.44,
      polsbyPopperScore: 0.42,
    },
    {
      imageUrl:
        'https://filipinotimes.net/wp-content/uploads/2019/08/moth-balls.jpg',
      imageAlt: 'Maryland',
      title: 'Random Districting 3',
      description:
        'This districting minimized the number of majority minority districts.',
      congressionalDistricts: 8,
      votingDistricts: '8,654',
      minorityMajorityDistrict: 3,
      threshold: 50,
      maxPopulationRange: 137429,
      populationScore: 86,
      efficiencyGapMeasure: 0.44,
      polsbyPopperScore: 0.42,
    },
  ];
  return <DistrictingCardList cards={cards} onSelect={onSelect} />;
};

export default DistrictingPreview;
