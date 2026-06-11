import {
Component,
OnInit,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router,
RouterModule
} from '@angular/router';

import {
Company
} from '../../../core/models/company.model';

import {
CompanyService
} from '../../../core/services/company.service';

@Component({

selector:
'app-company-list',

standalone:
true,

imports: [

CommonModule,
RouterModule

],

templateUrl:
'./company-list.html',

styleUrl:
'./company-list.css'

})

export class CompanyList
implements OnInit {

private companyService =
inject(
CompanyService
);

private router =
inject(
Router
);

companies:
Company[] =
[];

loading =
true;

error =
'';

ngOnInit(): void {

this.loadCompanies();

}

loadCompanies(): void {

this.loading =
true;

this.companyService
.findAll()

.subscribe({

next:
(data) => {

this.companies =
data;

this.loading =
false;

},

error:
() => {

this.error =
'No fue posible cargar empresas';

this.loading =
false;

}

});

}

goToCreate(): void {

this.router.navigate([

'/companies/new'

]);

}

goToEdit(
id: number
): void {

this.router.navigate([

'/companies/edit',
id

]);

}

}
