import { Component } from '@angular/core';
import { HttpService } from './http.service';
import { City } from './shared/city.model';
import { Weather } from './shared/weather.model';
import { Observable } from 'rxjs';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: [ './app.component.css' ]
})
export class AppComponent {
	title = 'teai-pracadomowa5-zadanie2';
	message = new FormMessage();
	locationsObservable: Observable<Array<City>>;
	locations: Array<City>;
	weatherObservable: Observable<Weather>;

	constructor(private httpService: HttpService) {}

	onSubmit() {
		this.locationsObservable = this.httpService.getWeatherStationsLocations(this.message.city);

		this.locationsObservable.toPromise().then((locations) => {
			this.locations = locations;
		});
	}
}

class FormMessage {
	constructor(public city?: string) {}
}
