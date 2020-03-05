import { ConsolidatedWeather } from './consolidated_weather.model';
import { Parent } from './parent.model';
import { Source } from './source.model';

export interface Weather {
	consolidated_weather?: ConsolidatedWeather;
	time?: string;
	sun_rise?: string;
	sun_set?: string;
	timezone_name?: string;
	parent?: Parent;
	sources?: Source;
	title?: string;
	location_type?: string;
	woeid?: string;
	latt_long?: string;
	timezone?: string;
}
