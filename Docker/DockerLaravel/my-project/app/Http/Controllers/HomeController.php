<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    // invoke es per administrar 1 funció
    public function __invoke(){
        return view('home');
    }
}
