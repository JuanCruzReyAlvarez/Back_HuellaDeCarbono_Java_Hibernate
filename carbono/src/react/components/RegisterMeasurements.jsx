import React from 'react'
import ".././styles/RegisterMeasurements.css";
import $ from 'jquery';


export const RegisterMeasurements = () => {
     function readURL(input) {
        if (input.files && input.files[0]) {
      
          var reader = new FileReader();
      
          reader.onload = function(e) {
            $('.image-upload-wrap').hide();
      
            $('.file-upload-image').attr('src', e.target.result);
            $('.file-upload-content').show();
      
            $('.image-title').html(input.files[0].name);
          };
      
          reader.readAsDataURL(input.files[0]);
      
        } else {
          removeUpload();
        }
      }
      
      function removeUpload() {
        $('.file-upload-input').replaceWith($('.file-upload-input').clone());
        $('.file-upload-content').hide();
        $('.image-upload-wrap').show();
      }
      $('.image-upload-wrap').bind('dragover', function () {
          $('.image-upload-wrap').addClass('image-dropping');
        });
        $('.image-upload-wrap').bind('dragleave', function () {
          $('.image-upload-wrap').removeClass('image-dropping');
      }); 
  return (
    <div className="RegistrarMediciones">
        <div className="bg-img">
            <div className="titulo">
                <h1>Registrar Mediciones</h1>
            </div>
            <div className="paragraph-mediciones">
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Assumenda, laborum! Maiores voluptatem consequatur exercitationem magnam a consectetur corrupti voluptatibus ratione, molestias ullam harum quis laborum vitae tenetur, iste facilis vero.</p>
            </div>

            <div className="file-upload">
                <div className="image-upload-wrap">
                    <input className="file-upload-input" type="file" onchange="readURL(this);" accept="image/*" />
                        <div className="drag-text">
                            <h3>Haz click aquí o arrastra un archivo</h3>
                        </div>
                </div>
                <div className="file-upload-content">
                        <img className="file-upload-image" src="#" alt="your image" />
                    <div className="image-title-wrap">
                        <button type="button" onclick="removeUpload()" className="remove-image">Cancelar Selección<span class="image-title">Archivo Seleccionado</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}