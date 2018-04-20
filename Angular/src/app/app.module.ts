import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ServicoService } from './servico/servico.service';

import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { FormsModule, ReactiveFormsModule, Validator} from '@angular/forms';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { ListaComponent } from './lista/lista.component';

const appRoutes: Routes =[
  { path : '', component   : ListaComponent},
  { path : 'form', component : FormComponent}
  ]

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    ListaComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ServicoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
