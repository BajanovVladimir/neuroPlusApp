import {modalWindowShow} from './utils.js';
import {modalWindowShowIfRadioButtonSelected} from './utils.js';
import {submitFormIfRadioButtonSelected} from './utils.js';
import {modalWindowClose} from './utils.js';
import {modalWindowSubmit} from './utils.js';
import {doubleValidation} from './utils.js';
import {integerValidation} from './utils.js';
//-----------------------------Service Add---------------------
const showWindowServiceAddBtn = document.querySelector('#serviceAddBtn');
const windowServiceAdd = document.querySelector('#modalServiceAdd');
const closeWindowServiceAddBtn = document.querySelector('#buttonModalAddWindowClose');
const buttonAddService = document.querySelector('#buttonAddService');
const serviceAddForm = document.querySelector('#serviceAddForm');

modalWindowShow(windowServiceAdd, showWindowServiceAddBtn);
modalWindowClose(closeWindowServiceAddBtn, windowServiceAdd);

submitFormIfRadioButtonSelected('serviceId',serviceAddForm,buttonAddService);
//-----------------------------End Service Add-----------------
//-----------------------------EmployeeCard--------------------
const redirectEmployeesViewForm = document.querySelector('#redirectEmployeesViewForm');
const closeEmployeeCardBtn = document.querySelector('#closeEmployeeCardBtn');
const deleteEmployeeForm = document.querySelector('#deleteEmployeeForm');
const deleteEmployeeBtn = document.querySelector('#deleteEmployeeBtn');

closeEmployeeCardBtn.addEventListener('click', () => {
   redirectEmployeesViewForm.submit();
});

deleteEmployeeBtn.addEventListener('click', () => {
   deleteEmployeeForm.submit();
});
//-----------------------------End EmployeeCard------------------
