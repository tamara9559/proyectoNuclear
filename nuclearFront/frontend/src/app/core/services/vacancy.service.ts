import { Injectable } from '@angular/core';

import {
HttpClient
} from '@angular/common/http';

import {
Observable
} from 'rxjs';

import {
Vacancy
} from '../models/vacancy.model';

@Injectable({
providedIn: 'root'
})

export class VacancyService {

private api =
'http://zealous-emotion-production-bfb7.up.railway.app/api/vacancies';

constructor(
private http: HttpClient
){}

create(
vacancy: Vacancy
): Observable<Vacancy> {

return this.http.post<Vacancy>(
this.api,
vacancy
);

}

update(
id: number,
vacancy: Vacancy
): Observable<Vacancy> {

return this.http.put<Vacancy>(
`${this.api}/${id}`,
vacancy
);

}

findById(
id: number
): Observable<Vacancy> {

return this.http.get<Vacancy>(
`${this.api}/${id}`
);

}

findAll(): Observable<Vacancy[]> {

return this.http.get<Vacancy[]>(
this.api
);

}

findOpen(): Observable<Vacancy[]> {

return this.http.get<Vacancy[]>(
`${this.api}/open`
);

}

findByCompany(
companyId: number
): Observable<Vacancy[]> {

return this.http.get<Vacancy[]>(
`${this.api}/company/${companyId}`
);

}

}