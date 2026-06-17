import {
CanActivateFn
}
from '@angular/router';

import {
inject
}
from '@angular/core';

import {
Router
}
from '@angular/router';

import {
AuthService
}
from '../services/auth.service';

export function roleGuard(
roles: string[]
): CanActivateFn {

return () => {

const auth =
inject(
AuthService
);

const router =
inject(
Router
);

if (
!auth.isLogged()
) {

router.navigate(
[
'/login'
]
);

return false;

}

const role =
auth.getRole();

if (
roles.includes(
role
)
) {

return true;

}

router.navigate(
[
'/dashboard'
]
);

return false;

};

}