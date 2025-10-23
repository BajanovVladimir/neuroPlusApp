import {modalWindowShow} from './utils.js';
import {modalWindowShowIfRadioButtonSelected} from './utils.js';
import {submitFormIfRadioButtonSelected} from './utils.js';
import {modalWindowClose} from './utils.js';
import {modalWindowSubmit} from './utils.js';
import {doubleValidation} from './utils.js';
import {integerValidation} from './utils.js';

//------------------------------Client add----------------------
const showDialogAddBtn = document.querySelector('#buttonAdd');
const modalAddWindow = document.querySelector('#modalAddWindow');
const closeModalAddWindowBtn = document.querySelector('#buttonModalAddWindowClose');

modalWindowShow(modalAddWindow, showDialogAddBtn);
modalWindowClose(closeModalAddWindowBtn, modalAddWindow);
addEmployeeBtn.addEventListener('click', () => {
   formAddEmployee.submit();
});
//------------------------------End client add-----------------