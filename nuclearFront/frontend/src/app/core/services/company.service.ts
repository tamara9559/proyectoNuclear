import { Injectable } from '@angular/core';

import {
HttpClient
} from '@angular/common/http';

import {
Observable
} from 'rxjs';

import {
Company
} from '../models/company.model';

@Injectable({
providedIn: 'root'
})

export class CompanyService {

private api =
'https://proyectonuclear-production.up.railway.app/api/companies';

constructor(
private http: HttpClient
){}

create(
company: Company
): Observable<Company> {

return this.http.post<Company>(
this.api,
company
);

}

update(
id: number,
company: Company
): Observable<Company> {

return this.http.put<Company>(
`${this.api}/${id}`,
company
);

}

findById(
id: number
): Observable<Company> {

return this.http.get<Company>(
`${this.api}/${id}`
);

}

findAll(): Observable<Company[]> {

return this.http.get<Company[]>(
this.api
);

}

findByNit(
nit: string
): Observable<Company> {

return this.http.get<Company>(
`${this.api}/nit/${nit}`
);

}

findBySector(
sector: string
): Observable<Company[]> {

return this.http.get<Company[]>(
`${this.api}/sector/${sector}`
);

}

}