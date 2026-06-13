import { Routes } from '@angular/router';

import { Dashboard } from './pages/dashboard/dashboard';

import { UserList } from './pages/users/user-list/user-list';
import { UserForm } from './pages/users/user-form/user-form';

import { StudentList } from './pages/students/student-list/student-list';
import { StudentForm } from './pages/students/student-form/student-form';

import { CompanyList } from './pages/companies/company-list/company-list';
import { CompanyForm } from './pages/companies/company-form/company-form';

import { VacancyList } from './pages/vacancies/vacancy-list/vacancy-list';
import { VacancyForm } from './pages/vacancies/vacancy-form/vacancy-form';

import { NotFound } from './pages/not-found/not-found';

import {
Layout
} from './shared/layout/layout/layout';

export const routes: Routes = [

{

path:
'',

component:
Layout,

children: [

{
path:
'users',
loadComponent:
() =>
import(
'./pages/users/user-list/user-list'
)
.then(
m =>
m.UserList
)
},

{
path:
'companies',
loadComponent:
() =>
import(
'./pages/companies/company-list/company-list'
)
.then(
m =>
m.CompanyList
)
},

{
path:
'students',
loadComponent:
() =>
import(
'./pages/students/student-list/student-list'
)
.then(
m =>
m.StudentList
)
},

{
path:
'vacancies',
loadComponent:
() =>
import(
'./pages/vacancies/vacancy-list/vacancy-list'
)
.then(
m =>
m.VacancyList
)
}

]

},

{
path: 'users/new',
component: UserForm
},

{
path: 'students',
component: StudentList
},

{
path: 'students/new',
component: StudentForm
},

{
path: 'companies',
component: CompanyList
},

{
path: 'companies/new',
component: CompanyForm
},

{
path: 'vacancies',
component: VacancyList
},

{
path: 'vacancies/new',
component: VacancyForm
},

{
path:
'users/edit/:id',
component:
UserForm
},

{
path:
'students/edit/:id',
component:
StudentForm
},

{
path:
'companies/edit/:id',
component:
CompanyForm
},

{
path:
'vacancies/edit/:id',
component:
VacancyForm
},

{
path: '**',
component: NotFound
}

];