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

interface DashboardModule {

title: string;

description: string;

route: string;

}

@Component({

selector:
'app-dashboard',

standalone:
true,

imports:[
CommonModule
],

templateUrl:
'./dashboard.html',

styleUrl:
'./dashboard.css'

})

export class Dashboard {

private auth =
inject(
AuthService
);

constructor(
private router: Router
){}

role =
this.auth.getRole();

roleModules:
Record<
string,
DashboardModule[]
> = {

ESTUDIANTE:[

{
title:'Vacantes',
description:'Consultar oportunidades',
route:'/vacancies'
},

{
title:'Mi práctica',
description:'Ver estado de práctica',
route:'/practices'
},

{
title:'Documentos',
description:'Gestionar documentos',
route:'/documents'
},

{
title:'FAQs',
description:'Preguntas frecuentes',
route:'/faqs'
}

],

EGRESADO:[

{
title:'Vacantes',
description:'Buscar ofertas',
route:'/vacancies'
},

{
title:'Postulaciones',
description:'Gestionar postulaciones',
route:'/applications'
},

{
title:'FAQs',
description:'Preguntas frecuentes',
route:'/faqs'
}

],

EMPRESA:[

{
title:'Mis vacantes',
description:'Administrar vacantes',
route:'/vacancies'
},

{
title:'Selección',
description:'Gestionar candidatos',
route:'/selection'
},

{
title:'Convenios',
description:'Administrar convenios',
route:'/agreements'
},

{
title:'Evaluaciones',
description:'Registrar evaluaciones',
route:'/evaluations'
}

],

DOCENTE:[

{
title:'Estudiantes',
description:'Consultar estudiantes',
route:'/students'
},

{
title:'Seguimiento',
description:'Monitoreo académico',
route:'/monitorings'
},

{
title:'Evaluaciones',
description:'Evaluar estudiantes',
route:'/evaluations'
}

],

COORDINADOR:[

{
title:'Estudiantes',
description:'Administrar estudiantes',
route:'/students'
},

{
title:'Empresas',
description:'Administrar empresas',
route:'/companies'
},

{
title:'Vacantes',
description:'Gestionar vacantes',
route:'/vacancies'
},

{
title:'Matching',
description:'Relacionar perfiles',
route:'/matching'
},

{
title:'Selección',
description:'Proceso de selección',
route:'/selection'
},

{
title:'Prácticas',
description:'Administrar prácticas',
route:'/practices'
},

{
title:'Convenios',
description:'Gestionar convenios',
route:'/agreements'
},

{
title:'Documentos',
description:'Administrar documentos',
route:'/documents'
},

{
title:'Seguimiento',
description:'Monitorear procesos',
route:'/monitorings'
},

{
title:'FAQs',
description:'Administrar preguntas',
route:'/faqs'
}

],

ADMIN:[

{
title:'Usuarios',
description:'Administrar usuarios',
route:'/users'
}

]

};

visibleModules(): DashboardModule[] {

return (

this.roleModules[
this.role
]

??

[]

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