import {
Component,
inject
}
from '@angular/core';

import {
RouterModule,
RouterOutlet
}
from '@angular/router';

import {
AuthService
}
from '../../../core/services/auth.service';

@Component({

selector:
'app-layout',

standalone:
true,

imports:[
RouterModule,
RouterOutlet
],

templateUrl:
'./layout.html',

styleUrl:
'./layout.css'

})

export class Layout {

private auth =
inject(
AuthService
);

role =
this.auth.getRole();

logout(): void {

this.auth.logout();

location.href =
'/login';

}

}