import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {Capsula} from '../capsula';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class ServicoService {

  private urlBase: string = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers, });
  private Capsula : Capsula;

  constructor(private _http:Http) { }

  getCapsulas(){
  	return this._http.get(this.urlBase+"/capsulas", this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

   deleteCapsula(id:number){
  	return this._http.delete(this.urlBase+"/capsula/"+id, this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

  novoCapsula(Capsula:Capsula){
  	return this._http.post(this.urlBase+"/capsula",JSON.stringify(Capsula), this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

  updateCapsula(Capsula:Capsula){
  	return this._http.put(this.urlBase+"/capsula",JSON.stringify(Capsula), this.options).map(
  		(response:Response) => response.json()).catch(this.errorHandler);
  }

  errorHandler(Error:Response){
  	return Observable.throw(Error || "Erro no Servidor");
  }

  getter(){
    return this.Capsula;
  }

  setter(Capsula:Capsula){
    this.Capsula = Capsula;
  }


}
