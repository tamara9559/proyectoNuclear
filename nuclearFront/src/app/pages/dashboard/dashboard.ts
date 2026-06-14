import {
Component
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router
} from '@angular/router';

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

modules = [

{
title:
'Usuarios',

description:
'Administrar usuarios del sistema',

route:
'/users'
},

{
title:
'Empresas',

description:
'Gestionar empresas registradas',

route:
'/companies'
},

{
title:
'Estudiantes',

description:
'Administrar estudiantes y prácticas',

route:
'/students'
},

{
title:
'Vacantes',

description:
'Gestionar ofertas de práctica',

route:
'/vacancies'
}

];

goTo(
route: string
): void {

this.router.navigate([
route
]);

}

}