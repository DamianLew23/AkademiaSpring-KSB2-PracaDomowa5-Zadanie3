import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City } from './shared/city.model';
import { Weather } from './shared/weather.model';

@Injectable({
	providedIn: 'root'
})
export class HttpService {
	constructor(private http: HttpClient) {}

	getWeatherStationsLocations(cityName: string): Observable<Array<City>> {
		return this.http.get<Array<City>>('http://localhost:8080/api/cities?name=' + cityName);
	}

	getWeather(woeid: number): Observable<Weather> {
		return this.http.get<Weather>('http://localhost:8080/api/weather/' + woeid + '/');
	}
}
