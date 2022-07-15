#Author: maslachahawwaliyah@gmail.com
Feature: Request Staff

  #47
  @menekanSubmenuPending
  Scenario: Request Staff pending MNGR
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    Then Validasi loging sub menu pending

  @searchData
  Scenario Outline: Request Staff pending MNGR search data positif test
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    And User melakukan search data berdasarkan search <search>
    Then Data tampil

    Examples: 
      | search        |
      | adhitya       |
      | karyawan baru |

  #SHOW DATA
  @showData
  Scenario: Request Staff pending MNGR show data
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    And User melakukan show data
    Then Data tampil
    And User validasi show data sesuai

  @KaryawanBaru
  Scenario Outline: Pending MNGR input data Nik
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @Nikterdaftar
  Scenario Outline: Pending MNGR input data Nik Data yang terdaftar
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @selectPosisiDilakukan
  Scenario Outline: Pending MNGR input data Nik Data yang terdaftar
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User melakukan input tujuan, NIK <nik>, select posisi dilakukan, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @JumlahOrangValid
  Scenario Outline: Pending MNGR input data jumlah orang valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @mulaiKerjaDatePicker
  Scenario Outline: Pending MNGR input data mulai kerja datepicker
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, input mulai kerja dengan date picker, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @mulaiKerjaInputManual
  Scenario Outline: Pending MNGR input data mulai kerja input manual
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, input mulai kerja manual, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @lokasiKerjaDika
  Scenario Outline: Pending MNGR input data lokasi kerja pilih dika 1 lt 2
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja DIKA, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @lokasikerja
  Scenario Outline: Pending MNGR input data lokasi kerja valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @detailLokasiKerjaHurufAngkaSpk
  Scenario Outline: Pending MNGR input data detail lokasi kerja dengan huruf angka dan spesial karakter
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, melakukan input detail lokasi dengan huruf angka dan spesial karakter <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi    | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | jl lima delapan | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 |       123456789 | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | !!..^^..!!      | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @deskripsiPekerjaanHurufAngkaSpk
  Scenario Outline: Pending MNGR input data deskripsi pekerjaan dengan huruf angka dan spesial karakter
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, detail lokasi <detailLokasi>, melakukan input deskripsi pekerjaan dengan huruf angka dan spesial karakter <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk  | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test1 |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | 12345 |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | !.^.! |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #===========================================
  #FORM KUALIFIKASI
  #
  @selectJKdilakukan
  Scenario Outline: Pending MNGR input data select jenis kelamin dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #
  @umurDataValid
  Scenario Outline: Pending MNGR input data umur dengan data valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #masih eror # #berhasil
  @selectPendidikanDilakukan
  Scenario Outline: Pending MNGR input data select pendidikan dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #masih eror # #berhasil
  @selectStatusPerkawinanDilakukan
  Scenario Outline: Pending MNGR input data select status perkawinan dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #masih eror # #sudah bisa
  @inputkualifikasiLainnyaValid
  Scenario Outline: Pending MNGR input data kualifikasi lainnya dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, melakukan input kualifikasi lainnya dengan huruf angka dan spesial karakter <kl>
    And User melengkapi status karyawan, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | 12345 |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | !.^.! |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #======================================
  #FORM STATUS KARYAWAN
  @memilihStatusKaryawanPermanen
  Scenario Outline: Pending MNGR input data memilih status karyawan permanen
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan permanen, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @memilihStatusKaryawanPKWT
  Scenario Outline: Pending MNGR input data memilih status karyawan PKWT
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan PKWT, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanPKWTCheckBulan
  Scenario Outline: Pending MNGR input data memilih status karyawan PKWT check bulan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan PKWT, check bulan bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanPKWTCheckTahun
  Scenario Outline: Pending MNGR input data memilih status karyawan PKWT check tahun
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan PKWT, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMagang
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang input bulan dan tahun valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Magang, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #masih eror #sudah bisa
  @KaryawanMagangHarian
  Scenario Outline: Pending MNGR input data memilih status karyawan Magang Harian input bulan dan tahun valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, memilih status karyawan Magang Harian, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @KaryawanMitra
  Scenario Outline: Pending MNGR input data memilih status karyawan Mitra input bulan dan tahun valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, pilih karyawan Mitra, bulan <bln>, tahun <thn>, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #masih eror #sudah
  @cekMasaPercobaan
  Scenario Outline: Pending MNGR input data masa percobaan dengan angka
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan masa percobaan dengan angka <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  @cekGolonganJabatanValid
  Scenario Outline: Pending MNGR select golongan jabatan dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, select golongan jabatan dilakukan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #GAJI
  @cekGajiValid
  Scenario Outline: Pending MNGR input data cek gaji dengan data valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #ASURANSI
  @checkboxAsuransi
  Scenario Outline: Pending MNGR input data checkbox asuransi dipilih
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, checkbox asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #TUNJANGAN JABATAN
  @tunjanganJabatanValid
  Scenario Outline: Pending MNGR input data cek tunjangan jabatan dengan data valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, input field tunjangan jabatan dengan data valid <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #TUNJANGAN TRANSPORTASI
  @tunjanganTransportasiValid
  Scenario Outline: Pending MNGR input data cek tunjangan transportasi dengan data valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, data valid tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #TUNJANGAN KOMUNIKASI
  @tunjanganKomunikasiValid
  Scenario Outline: Pending MNGR input data cek tunjangan komunikasi dengan data valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, input tunjangan komunikasi dengan data valid <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #NOTE
  @noteDataValid
  Scenario Outline: Pending MNGR input data cek note dengan data valid
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, golongan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, input note dengan data valid <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | masa | gaji | tj  | transport | tk  | note      |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | satu dua  |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 |  12345678 |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |    4 | 1000 | 500 |       300 | 200 | !(.^-^.)! |

  #CEK BTN KIRIM
  @suksesbtnkirim
  Scenario Outline: Pending MNGR select golongan jabatan dilakukan
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button input data
    And User input tujuan, NIK <nik>, posisi, jumlah orang <jumlahOrang>, mulai kerja, lokasi kerja, kota kerja, input detail lokasi <detailLokasi>, deskripsi pekerjaan <desk>
    And User melakukan tambah field kualifikasi jenis kelamin, umur awal <umur1>, batas umur <umur2>, pendidikan, status perkawinan, kualifikasi lainnya <kl>
    And User melengkapi status karyawan, masa percobaan <masa>, select golongan jabatan dilakukan, gaji <gaji>, asuransi, tunjangan jabatan <tj>, tunjangan transportasi <transport>, tunjangan komunikasi <tk>, note <note>
    And User klik tombol kirim
    Then Data tersimpan

    Examples: 
      | nik      | jumlahOrang | detailLokasi | desk | umur1 | umur2 | kl    | bln | thn | masa | gaji | tj  | transport | tk  | note     |
      | D6180209 |           1 | Jl. Satu Dua | test |    20 |    26 | skill |   3 |   1 |    4 | 1000 | 500 |       300 | 200 | satu dua |

  #DETAIL DATA
  @cekDetailData
  Scenario: Pending MNGR cek detail data btn eye
    Given User berhasil login sebagai MNGR
    When User memilih Request Staff
    And User memilih sub menu Pending
    When User menekan button plus dan eye
    Then User validasi detail data permintaan baru
