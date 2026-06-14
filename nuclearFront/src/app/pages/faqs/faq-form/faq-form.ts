import {
Component,
inject,
OnInit
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
ReactiveFormsModule,
FormBuilder,
Validators
} from '@angular/forms';

import {
ActivatedRoute,
Router
} from '@angular/router';

import {
FaqService
} from '../../../core/services/faq.service';

import {
FAQ
} from '../../../core/models/faq.model';

@Component({

selector:
'app-faq-form',

standalone:
true,

imports: [
CommonModule,
ReactiveFormsModule
],

templateUrl:
'./faq-form.html',

styleUrl:
'./faq-form.css'

})

export class FaqForm
implements OnInit {

private fb =
inject(
FormBuilder
);

private service =
inject(
FaqService
);

private route =
inject(
ActivatedRoute
);

private router =
inject(
Router
);

edit = false;

id?: number;

form =
this.fb.group({

pregunta:
[
'',
Validators.required
],

respuesta:
[
''
],

categoria:
[
'GENERAL',
Validators.required
]

});

ngOnInit(): void {

this.id =
Number(
this.route.snapshot.paramMap.get(
'id'
)
);

if (this.id) {

this.edit =
true;

this.service
.findById(
this.id
)
.subscribe(
faq => {

this.form.patchValue(
faq
);

}
);

}

}

save(): void {

if (
this.form.invalid
)
return;

const faq: FAQ = {

id:
this.id,

pregunta:
this.form.value.pregunta ?? '',

respuesta:
this.form.value.respuesta ?? '',

categoria:
this.form.value.categoria ?? '',

estado:
true,

fechaCreacion:
''

};

const request =
this.edit
? this.service.update(
this.id!,
faq
)
: this.service.create(
faq
);

request.subscribe(
() => {

this.router.navigate([
'/faqs'
]);

}
);

}

}