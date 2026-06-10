import {
Component,
OnInit
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Company
} from '../../../core/models/company.model';

import {
CompanyService
} from '../../../core/services/company.service';

@Component({
selector: 'app-company-list',

standalone: true,

imports: [
CommonModule
],

templateUrl: './company-list.html',

styleUrl: './company-list.css'
})

export class CompanyList
implements OnInit {

companies: Company[] = [];

loading = true;

error = '';

constructor(
private companyService: CompanyService
){}

ngOnInit(): void {

this.loadCompanies();

}

loadCompanies(): void {

this.loading = true;

this.companyService
.findAll()
.subscribe({

next: (data) => {

this.companies = data;

this.loading = false;

},

error: () => {

this.error =
'No fue posible cargar empresas';

this.loading = false;

}

});

}

}