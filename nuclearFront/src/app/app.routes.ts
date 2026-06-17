  import { Routes } from '@angular/router';

  import { Layout } from './shared/layout/layout/layout';

  import { Dashboard } from './pages/dashboard/dashboard';
  import { Login } from './pages/login/login';

  import { UserList } from './pages/users/user-list/user-list';
  import { UserForm } from './pages/users/user-form/user-form';

  import { StudentList } from './pages/students/student-list/student-list';
  import { StudentForm } from './pages/students/student-form/student-form';

  import { CompanyList } from './pages/companies/company-list/company-list';
  import { CompanyForm } from './pages/companies/company-form/company-form';

  import { VacancyFeed } from './pages/vacancies/vacancy-feed/vacancy-feed';
  import { VacancyDetail } from './pages/vacancies/vacancy-detail/vacancy-detail';
  import { VacancyForm } from './pages/vacancies/vacancy-form/vacancy-form';

  import { Ranking } from './pages/matching/ranking/ranking';

  import { ApplicationList } from './pages/applications/application-list/application-list';
  import { ApplicationForm } from './pages/applications/application-form/application-form';
  import { ApplicationReview } from './pages/applications/application-review/application-review';

  import { SelectionActions } from './pages/selections/selection-actions';
  import { SelectionApproval } from './pages/selections/selection-approval/selection-approval';

  import { AgreementList } from './pages/agreements/agreement-list/agreement-list';
  import { AgreementForm } from './pages/agreements/agreement-form/agreement-form';

  import { EvaluationList } from './pages/evaluations/evaluation-list/evaluation-list';
  import { EvaluationForm } from './pages/evaluations/evaluation-form/evaluation-form';

  import { PracticeList } from './pages/practices/practice-list/practice-list';
  import { PracticeForm } from './pages/practices/practice-form/practice-form';

  import { DocumentList } from './pages/documents/document-list/document-list';
  import { DocumentForm } from './pages/documents/document-form/document-form';

  import { FaqList } from './pages/faqs/faq-list/faq-list';
  import { FaqForm } from './pages/faqs/faq-form/faq-form';

  import { MonitoringList } from './pages/monitorings/monitoring-list/monitoring-list';
  import { MonitoringForm } from './pages/monitorings/monitoring-form/monitoring-form';

  import { Profile } from './pages/profile/profile';

  import { authGuard } from './core/guards/auth.guard';
  import { guestGuard } from './core/guards/guest.guard';
  import { roleGuard } from './core/guards/role.guard';

  import { Register } from './pages/register/register';

  export const routes: Routes = [

  {
  path: 'login',
  component: Login,
  canActivate: [guestGuard]
  },

  {
    path: 'register',
    component: Register
  },

  {
  path: '',
  component: Layout,
  canActivate: [authGuard],

  children: [

  {
  path: '',
  redirectTo: 'dashboard',
  pathMatch: 'full'
  },

  {
path: 'dashboard',
component: Dashboard
},

  {
  path: 'profile',
  component: Profile
  },

  {
    path: 'users',
    loadComponent: () =>
      import('./pages/users/user-list/user-list')
        .then(m => m.UserList),
    canActivate: [roleGuard(['ADMIN'])]
  },

  {
  path: 'users/new',
  component: UserForm,
  canActivate: [roleGuard(['ADMIN'])]
  },

  {
  path: 'users/edit/:id',
  component: UserForm,
  canActivate: [roleGuard(['ADMIN'])]
  },

  {
path:'students',
component:StudentList,
canActivate:[
roleGuard([
'DOCENTE',
'COORDINADOR'
])
]
},

  {
path:'students/new',
component:StudentForm,
canActivate:[
roleGuard([
'ADMIN'
])
]
},

  {
path:'students/edit/:id',
component:StudentForm,
canActivate:[
roleGuard([
'DOCENTE',
'COORDINADOR'
])
]
},

  {
  path: 'companies',
  component: CompanyList,
  canActivate: [roleGuard(['ADMIN', 'COORDINADOR'])]
},


  {
    path: 'companies/new',
    component: CompanyForm,
    canActivate: [roleGuard(['ADMIN', 'COORDINADOR'])]
  },

  {
path:'companies/edit/:id',
component:CompanyForm,
canActivate:[
roleGuard([
'COORDINADOR'
])
]
},

  {
path:'vacancies',
component:VacancyFeed,
canActivate:[
roleGuard([
'ESTUDIANTE',
'EGRESADO',
'EMPRESA',
'COORDINADOR'
])
]
},

  {
  path: 'vacancies/:id',
  component: VacancyDetail
  },

  {
path:'vacancies/new',
component:VacancyForm,
canActivate:[
roleGuard([
'EMPRESA'
])
]
},

  {
path:'vacancies/edit/:id',
component:VacancyForm,
canActivate:[
roleGuard([
'EMPRESA'
])
]
},

  {
path:'matching',
component:Ranking,
canActivate:[
roleGuard([
'ESTUDIANTE',
'COORDINADOR'
])
]
},
  {
path:'applications',
component:ApplicationList,
canActivate:[
roleGuard([
'EGRESADO'
])
]
},

  {
path:'applications/new',
component:ApplicationForm,
canActivate:[
roleGuard([
'EGRESADO'
])
]
},

  {
  path: 'application-review',
  component: ApplicationReview
  },

 {
path:'selection',
component:SelectionActions,
canActivate:[
roleGuard([
'EMPRESA',
'COORDINADOR'
])
]
},

  {
path:'selection-approval',
component:SelectionApproval,
canActivate:[
roleGuard([
'COORDINADOR'
])
]
},

  {
path:'agreements',
component:AgreementList,
canActivate:[
roleGuard([
'EMPRESA',
'COORDINADOR'
])
]
},

  {
  path: 'agreements/new',
  component: AgreementForm
  },

  {
  path: 'agreements/edit/:id',
  component: AgreementForm
  },

  {
path:'evaluations',
component:EvaluationList,
canActivate:[
roleGuard([
'DOCENTE',
'EMPRESA'
])
]
},

  {
  path: 'evaluations/new',
  component: EvaluationForm
  },

  {
  path: 'evaluations/edit/:id',
  component: EvaluationForm
  },

  {
  path: 'practices',
  component: PracticeList,
  canActivate: [
  roleGuard(['ESTUDIANTE'])
  ]
  },

  {
  path: 'practices/new',
  component: PracticeForm
  },

  {
  path: 'practices/edit/:id',
  component: PracticeForm
  },

  {
path:'documents',
component:DocumentList,
canActivate:[
roleGuard([
'ESTUDIANTE',
'COORDINADOR'
])
]
},

  {
  path: 'documents/new',
  component: DocumentForm
  },

  {
path:'faqs',
component:FaqList,
canActivate:[
roleGuard([
'ESTUDIANTE',
'EGRESADO',
'EMPRESA',
'DOCENTE',
'COORDINADOR'
])
]
},

  {
  path: 'faqs/new',
  component: FaqForm
  },

  {
  path: 'faqs/edit/:id',
  component: FaqForm
  },

  {
  path: 'monitorings',
  component: MonitoringList,
  canActivate: [
  roleGuard([
  'DOCENTE',
  'COORDINADOR'
  ])
  ]
  },

  {
  path: 'monitorings/new',
  component: MonitoringForm
  },

  ]

  },

  {
  path: '**',
  loadComponent: () =>
  import('./pages/errors/not-found/not-found')
  .then(m => m.NotFound)
  }

  ];
