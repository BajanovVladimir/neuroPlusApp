import {modalWindowShow} from './utils.js';
import {modalWindowShowIfRadioButtonSelected} from './utils.js';
import {modalWindowClose} from './utils.js';
import {modalWindowSubmit} from './utils.js';

//-----------------------Service ADD------------------------------------
const showDialogAddBtn = document.querySelector('#buttonAdd');
const modalAddWindow = document.querySelector('#modalAddWindow');
const closeModalAddWindowBtn = document.querySelector('#buttonModalAddWindowClose')

modalWindowShow(modalAddWindow, showDialogAddBtn);
modalWindowClose(closeModalAddWindowBtn, modalAddWindow);

//---------------------End Service ADD----------------------------------
//---------------------Service delete-----------------------------------
const showDialogDeleteBtn = document.querySelector('#buttonOpenWindowDelete');
const modalDeleteWindow = document.querySelector('#modalDeleteWindow');
const closeModalDeleteWindowBtn = document.querySelector('#closeModalDeleteWindowBtn');
const submitServiceDeleteBtn = document.querySelector('#buttonDeleteService');
modalWindowShowIfRadioButtonSelected(modalDeleteWindow, 'serviceId', showDialogDeleteBtn);
modalWindowClose(closeModalDeleteWindowBtn,modalDeleteWindow);
modalWindowSubmit(submitServiceDeleteBtn,'servicesForm');
//---------------------End Service delete-------------------------------