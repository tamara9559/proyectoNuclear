import {
Component,
inject
}
from '@angular/core';

import {
Router,
RouterModule,
RouterOutlet,
NavigationEnd
}
from '@angular/router';

import {
filter
}
from 'rxjs';

import {
AuthService
}
from '../../../core/services/auth.service';

import {
CommonModule
}
from '@angular/common';

@Component({

selector:
'app-layout',

standalone:true,

imports:[
RouterModule,
RouterOutlet,
CommonModule
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

private router =
inject(
Router
);

role='';

constructor(){

this.router.events

.pipe(

filter(
e=>
e instanceof NavigationEnd
)

)

.subscribe(()=>{

this.role =

this.auth

.getRole()

.trim();

console.log(
'ROLE:',
this.role
);

});

}

logout(){

this.auth.logout();

this.router.navigate([
'/login'
]);

}

}