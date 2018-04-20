import { Component, OnInit } from '@angular/core';
import { ServicoService } from '../servico/servico.service';
import { Capsula } from '../capsula'
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  private Capsulas:Capsula[];

  constructor(private _Service: ServicoService, private _router: Router) { }

  ngOnInit() {
    this._Service.getCapsulas().subscribe((Capsula) => {
      console.log(Capsula);
      this.Capsulas = Capsula;
        },(Error)=>{
          console.log(Error)
        }); 
  }


  deleteCapsula(Capsula:Capsula){
    this._Service.deleteCapsula(Capsula.idCapsula).subscribe((data)=>{
      this.Capsulas.splice(this.Capsulas.indexOf(Capsula), 1);
    }, (error)=>{
      console.log(error);
    })
  }

  updateCapsula(Capsula:Capsula){
    this._Service.setter(Capsula);
    this._router.navigate(['/form']);
  }

  novoCapsula(){
    let Caps = new Capsula();
    this._Service.setter(Caps);
    this._router.navigate(['/form']);
  }

}
