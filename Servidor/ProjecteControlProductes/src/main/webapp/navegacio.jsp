<%--
  Created by IntelliJ IDEA.
  User: SERGI
  Date: 09/11/2022
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
        data-bs-whatever="@fat">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square"
         viewBox="0 0 16 16">
        <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
    </svg>
</button>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Crear un nou</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="create">
                <div class="modal-body" style="color: black;">
                    <label>Nom :</label>
                    <input type="text" name="nom"><br>

                    <label>Descripcio :</label>
                    <input type="text" name="descripcio"><br>

                    <label>Preu :</label>
                    <input type="text" name="preu"><br>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Tancar</button>
                    <input type="submit" class="btn btn-primary" value="Enviar">
                </div>
            </form>
        </div>
    </div>
</div>