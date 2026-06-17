import { Injectable } from '@angular/core';

import {
HttpClient
} from '@angular/common/http';

import {
Observable
} from 'rxjs';

import {
User
} from '../models/user.model';

@Injectable({
providedIn: 'root'
})

export class UserService {

private api =
'http://zealous-emotion-production-bfb7.up.railway.app/api/users';

constructor(
private http: HttpClient
){}

create(
user: User
): Observable<User> {

return this.http.post<User>(
this.api,
user
);

}

update(
id: number,
user: User
): Observable<User> {

return this.http.put<User>(
`${this.api}/${id}`,
user
);

}

findById(
id: number
): Observable<User> {

return this.http.get<User>(
`${this.api}/${id}`
);

}

findAll(): Observable<User[]> {

return this.http.get<User[]>(
this.api
);

}

findByEmail(
email: string
): Observable<User> {

return this.http.get<User>(
`${this.api}/email/${email}`
);

}

activate(
id: number
): Observable<void> {

return this.http.put<void>(
`${this.api}/${id}/activate`,
{}
);

}

deactivate(
id: number
): Observable<void> {

return this.http.put<void>(
`${this.api}/${id}/deactivate`,
{}
);

}

}