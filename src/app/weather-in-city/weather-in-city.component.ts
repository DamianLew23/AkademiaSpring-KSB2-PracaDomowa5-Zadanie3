import { Component, OnInit, Input } from '@angular/core';
import { HttpService } from '../http.service';
import { Weather } from '../shared/weather.model';

@Component({
	selector: 'app-weather-in-city',
	templateUrl: './weather-in-city.component.html',
	styleUrls: [ './weather-in-city.component.css' ]
})
export class WeatherInCityComponent implements OnInit {
	@Input() woeid: number;
	weatherInCity: Weather;
	linkImage: string;

	constructor(private httpService: HttpService) {}

	ngOnInit() {
		this.getWeatherInCity(this.woeid);
	}

	getWeatherInCity(woeid: number) {
		this.httpService.getWeather(woeid).subscribe((weather) => {
			this.weatherInCity = weather;
			this.linkImage =
				'https://www.metaweather.com/static/img/weather/png/64/' +
				this.weatherInCity.consolidated_weather[0].weather_state_abbr +
				'.png';
		});
	}
}
