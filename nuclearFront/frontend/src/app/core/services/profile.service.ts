import {
Injectable,
inject
}
from '@angular/core';

import {
Observable
}
from 'rxjs';

import {
User
}
from '../models/user.model';

import {
UserService
}
from './user.service';

@Injectable({

providedIn:
'root'

})

export class ProfileService {

private users =
inject(
UserService
);

getProfile():

Observable<User>{

const email =

localStorage.getItem(
'correo'
);

return this.users.findByEmail(
email!
);

}

}