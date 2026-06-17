import {
Component,
inject
}
from '@angular/core';

import {
ReactiveFormsModule,
FormBuilder
}
from '@angular/forms';

import {
Router
}
from '@angular/router';

import {
CommonModule
}
from '@angular/common';

import {
UserService
}
from '../../core/services/user.service';

@Component({

selector:
'app-register',

standalone:
true,

imports:[
ReactiveFormsModule,
CommonModule
],

templateUrl:
'./register.html',

styleUrl:
'./register.css'

})

export class Register {

private fb =
inject(
FormBuilder
);

private users =
inject(
UserService
);

private router =
inject(
Router
);

form =
this.fb.group({

nombres:[''],

apellidos:[''],

correo:[''],

password:[''],

telefono:[''],

rol:['']

});

register(){

if(!this.form.value.rol){

alert(
'Seleccione un rol'
);

return;

}

this.users

.create({

nombres:
this.form.value.nombres!,

apellidos:
this.form.value.apellidos!,

correo:
this.form.value.correo!,

password:
this.form.value.password!,

telefono:
this.form.value.telefono!,

rol:
this.form.value.rol!,

estado:
true

})

.subscribe({

next:()=>{

alert(
'Cuenta creada'
);

this.router.navigate([
'/login'
]);

},

error:(e)=>{

console.log(e);

alert(
'Error creando usuario'
);

}

});

}

}