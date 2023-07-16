package com.app.chatbot.Data;

import com.app.chatbot.Model.Video;
import com.app.chatbot.R;

import java.util.ArrayList;

public class VideoData {
    private static final String [] nameVid = {
            "Kucing Lucu",
            "Kucing Gelud",
            "Kucing Lucuuuu",
            "Cats and Dogs",
            "Funniest Animal"
    };
    private static final String [] durasiVid = {
            "10 : 37",
            "13 : 29",
            "10 : 22",
            "10 : 21",
            "18 : 54"

    };
    private static final String [] urlVid = {
            "https://rr1---sn-npoe7nsy.googlevideo.com/videoplayback?expire=1689431668&ei=FFqyZOjeHojr4QSNq5LQAg&ip=143.244.34.207&id=o-ABcRHXkgR3EfTmcisHgCN7d-1SVJJ3DwLFCrwSvA_HI7&itag=18&source=youtube&requiressl=yes&spc=Ul2Sq7kce7NzFiO1kiPovDjt8eAnqOmZojswTQ6x1Q&vprv=1&svpuc=1&mime=video%2Fmp4&ns=eWK7viarw2uo2EdvVYPMzKMO&gir=yes&clen=48101397&ratebypass=yes&dur=637.632&lmt=1679690042300017&fexp=24007246,24350018,24362685&beids=24350018&c=WEB&txp=4530434&n=rtKSDLongkpUtQ&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAJfTtgXl2TjQufqH-7kF6JY4F_OdtVTvfWFECfqFJbpNAiEAysELMuJfdLx85VoqIXQDjDyp9HbGHKi-wHkHyzrORxY%3D&rm=sn-hp5ry7l&req_id=ff7bbd18baafa3ee&redirect_counter=2&cm2rm=sn-h5t5u5h5pq-q0hl7l&cms_redirect=yes&cmsv=e&ipbypass=yes&mh=Ia&mip=103.141.255.66&mm=29&mn=sn-npoe7nsy&ms=rdu&mt=1689425867&mv=m&mvi=1&pl=24&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAJaMZfcVq02xc2dks05hPrc4Ml7E3RyOoL0S0sy4LuWdAiEA1KOA1J8zlhSMrNpv8ymuT0Mg_uO7cQ9f32Ta1cCfb8Y%3D",
            "https://rr1---sn-npoe7ns6.googlevideo.com/videoplayback?expire=1689438689&ei=gXWyZOq-JZ7ox_AP6tmfuA0&ip=91.90.124.24&id=o-AIKX_qE0i5a7A4UYJ_TEPjEHL3KvQHRdtbnkfeG7ySRa&itag=18&source=youtube&requiressl=yes&spc=Ul2SqyRjkhCAnMYOdz0ZH-gJ7Byer8BoOztLHuqBeQ&vprv=1&svpuc=1&mime=video%2Fmp4&ns=aj07MvnzM-ccmAV-tcCUypQO&cnr=14&ratebypass=yes&dur=809.656&lmt=1664077235623470&fexp=24007246,24350017,51000024&beids=24350017&c=WEB&txp=5438434&n=l2-WeamdjoXxOg&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgR4qQSlfR4mZ8MsC3NaBVizEFzCr02UirvuDDrpHQNNcCICUIygy-p92-kOR_VGtykOCuZIHh40kn5O1jYGoXHY9-&redirect_counter=1&cm2rm=sn-q0ce77l&req_id=d81a545bca3ea3ee&cms_redirect=yes&mh=Hc&mip=103.141.255.66&mm=34&mn=sn-npoe7ns6&ms=ltu&mt=1689425591&mv=m&mvi=1&pl=24&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAIk2ji-HgsyNrrv8TDygdkAceKocvWpBZMqPo99Z8ZWLAiEAsnIKSiEw26XbVbSGp3stsMp2wxJN3SaC6NVM44-ekdQ%3D",
            "https://rr5---sn-npoe7nsk.googlevideo.com/videoplayback?expire=1689448314&ei=GpuyZMygK7CSsfIPvfaVwA8&ip=191.96.255.54&id=o-AF5yRDH7hVih010fO2oc3nffWJpRhUPIXDnG2oBCDkSd&itag=18&source=youtube&requiressl=yes&spc=Ul2Sq4iETJWv3gBgk_zMvQsnh4oGJ1d77pHdG4QBgg&vprv=1&svpuc=1&mime=video%2Fmp4&ns=wVTBadE__C2xIW_X9S2bngUO&gir=yes&clen=46661969&ratebypass=yes&dur=622.336&lmt=1688623718801623&fexp=24007246,24363393&c=WEB&txp=5530434&n=7cYRi3SOdJEEtQ&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgXFiwzJcaYi0r4vCazTEurudk1EU3GJG2SUhMYNLgxRkCIQDLWnCHiv4RdPj8i2otgBm_S5hLR-5zj_8nXY2dEI6cJw%3D%3D&rm=sn-a5meed7z&req_id=704a7cedc5bea3ee&redirect_counter=2&cm2rm=sn-h5t5u5h5pq-q0hl7e&cms_redirect=yes&cmsv=e&ipbypass=yes&mh=xH&mip=103.141.255.66&mm=29&mn=sn-npoe7nsk&ms=rdu&mt=1689425867&mv=m&mvi=5&pl=24&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAOsshUUR1cSpnaupOiFZYK9Fe0rBio0g1J7DsRvGU5QZAiBF3STR89pK3pVz0idL1Mux9JuB38AN3-zE4K7ny2gRGw%3D%3D",
            "https://rr1---sn-h5t5u5h5pq-q0hl.googlevideo.com/videoplayback?expire=1689443665&ei=8YiyZNvkB5T9WJ-7tPAD&ip=185.188.255.88&id=o-AKFWf8ITRBjdPT-Kfc-puqZ6IuocFobGFTx3CsROzMt1&itag=18&source=youtube&requiressl=yes&spc=Ul2Sq-r9lheUQygZz2utwPArk4KV6JH4w0xvXk0Yhw&vprv=1&svpuc=1&mime=video%2Fmp4&ns=tUAj5ewX1O9s3AuSYJeB2oEO&gir=yes&clen=47246968&ratebypass=yes&dur=621.034&lmt=1689236980984689&fexp=24007246,24350017&beids=24350017&c=WEB&txp=4530434&n=blCMxzpnUUkUTg&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAP-9nVliXz5wdtlX8JPo8Vd6nB6BDZoPUMR8OagkyCYXAiEAiHnGxDCmwVpEHaJJ3kLwxWDvqrUOkKi_xtb3pincGuo%3D&redirect_counter=1&rm=sn-aigez67l&req_id=56c4696be719a3ee&cms_redirect=yes&cmsv=e&ipbypass=yes&mh=4o&mip=103.141.255.66&mm=31&mn=sn-h5t5u5h5pq-q0hl&ms=au&mt=1689426557&mv=m&mvi=1&pcm2cms=yes&pl=24&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pcm2cms,pl&lsig=AG3C_xAwRQIhANqDy_iWGTC4C3tep34hRoj4K833p-P3KGHNgmzeBBbFAiAumfBqElAj4ir9gUgMl5s-R3a6yQw-cIZjGrcUstx_5g%3D%3D",
            "https://rr5---sn-npoldn7s.googlevideo.com/videoplayback?expire=1689448657&ei=cZyyZK-6FaCa0u8P09eA4Aw&ip=196.196.53.94&id=o-AGONaOEb0mqSbxID-oLIKNmKYFL2ieKSSEqneYyBZT9x&itag=18&source=youtube&requiressl=yes&spc=Ul2Sq_8ZWlw7NPe2sVGOLDJTyzEaCoAOufPF_cDlOA&vprv=1&svpuc=1&mime=video%2Fmp4&ns=KSd28Jv219OkOZ6beTlN51EO&gir=yes&clen=85213709&ratebypass=yes&dur=1134.186&lmt=1673105128585014&fexp=24007246&c=WEB&txp=5530434&n=AZ-Vk4d3vfBeLw&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgKhEYHhjyGYSCyeDvrtKhuv2MKYT96ZE5mmQbUD3gIDkCIQDkKWwFPDubuZK2H1jKlGHbcaTpG5usI7cQ6reVInQvlw%3D%3D&redirect_counter=1&rm=sn-4g5ezd7l&req_id=97aeef4b2feca3ee&cms_redirect=yes&cmsv=e&mh=Hr&mip=103.141.255.66&mm=34&mn=sn-npoldn7s&ms=ltu&mt=1689425661&mv=u&mvi=5&pl=24&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhANdAHYolPlGnk53MMGbWJQM_qgcOjPDGSFPf06yjeiLYAiAzq6WlXh4DVkUOQz5JoxWbNFziGb5TVzn5YXU9pJ9nnA%3D%3D"
    };
    private static final int [] gambarVid = {
            R.drawable.kucing_1,
            R.drawable.kucing_2,
            R.drawable.kucing_3,
            R.drawable.kucing_4,
            R.drawable.kucing_5
    };

    public static ArrayList<Video> getListData() {
        ArrayList<Video> list = new ArrayList<>();
        for (int position = 0; position < nameVid.length; position++) {
            Video video = new Video();
            video.setName(nameVid[position]);
            video.setDurasi(durasiVid[position]);
            video.setUrl(urlVid[position]);
            video.setGambar(gambarVid[position]);
            list.add(video);
        }
        return list;
    }
}
