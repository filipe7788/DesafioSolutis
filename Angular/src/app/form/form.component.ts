import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, FormsModule } from '@angular/forms';
import { ServicoService } from '../servico/servico.service';
import { Capsula } from '../capsula'
import { Router } from '@angular/router';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  private Capsula: Capsula = new Capsula();
  form: FormGroup;

  constructor(private _Servico: ServicoService, private _router: Router) {
  }

  ngOnInit() {
    this.Capsula = this._Servico.getter();
  }

  processForm() {
    if (!this.Capsula.idCapsula) {
      this._Servico.novoCapsula(this.Capsula).subscribe((Capsula) => {
        console.log(Capsula);
        this._router.navigate(['/']);
      }, (Error) => {
        console.log(Error);
      });
    } else {
      this._Servico.updateCapsula(this.Capsula).subscribe((Capsula) => {
        this._router.navigate(['/']);
        console.log(Capsula);
      }, (Error) => {
        console.log(Error);
      });
    }
  }

}
