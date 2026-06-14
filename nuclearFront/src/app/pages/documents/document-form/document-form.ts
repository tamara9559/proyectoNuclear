import {
Component,
inject
} from '@angular/core';

import {
ReactiveFormsModule,
FormBuilder,
Validators
} from '@angular/forms';

import {
Router
} from '@angular/router';

import {
DocumentService
} from '../../../core/services/document.service';

import {
CommonModule
} from '@angular/common';

@Component({

selector:
'app-document-form',

standalone:
true,

imports: [
CommonModule,
ReactiveFormsModule
],

templateUrl:
'./document-form.html',

styleUrl:
'./document-form.css'

})

export class DocumentForm {

private fb =
inject(
FormBuilder
);

private service =
inject(
DocumentService
);

private router =
inject(
Router
);

form =
this.fb.group({

estudianteId:
[
0,
Validators.required
],

empresaId:
[
0
],

convenioId:
[
0
],

nombre:
[
''
],

tipoDocumento:
[
''
],

urlArchivo:
[
''
],

fechaCarga:
[
''
],

estado:
[
''
]

});

save(): void {

if (
this.form.invalid
) {

return;

}

this.service
.upload(
this.form.getRawValue() as any
)
.subscribe(() => {

this.router.navigate([
'/documents'
]);

});

}

}