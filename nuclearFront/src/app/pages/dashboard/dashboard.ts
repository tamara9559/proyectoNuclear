import {
Component,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router
} from '@angular/router';

import {
AuthService
}
from '../../core/services/auth.service';

@Component({

selector:
'app-dashboard',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./dashboard.html',

styleUrl:
'./dashboard.css'

})



export class Dashboard {

constructor(
private router: Router
) {}

private auth =
inject(
AuthService
);

role =
this.auth.getRole();

modules = [

{
title:'Usuarios',
description:'Administrar usuarios',
route:'/users',
roles:['ADMIN']
},

{
title:'Empresas',
description:'Empresas registradas',
route:'/companies',
roles:[
'ADMIN',
'COORDINADOR'
]
},

{
title:'Vacantes',
description:'Ver vacantes',
route:'/vacancies',
roles:[
'EMPRESA',
'ESTUDIANTE',
'EGRESADO'
]
}

];

visibleModules(){

return this.modules.filter(

m=>

m.roles.includes(
this.role
)

);

}

goTo(
route: string
): void {

this.router.navigate([
route
]);

}

}