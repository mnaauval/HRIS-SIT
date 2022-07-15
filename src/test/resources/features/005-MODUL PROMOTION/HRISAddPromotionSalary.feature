#Author: intanjuniar101@gmail.com
Feature: Add Pengajuan Promotion

  @salary01
  Scenario Outline: Add data Perubahan salary *Gapok*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok     | jabatan | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W |   5000000 | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 500000,00 | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  Scenario Outline: Add data Perubahan salary *variasiData_Gapok*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field gapok kosong

    Examples: 
      | nik                              | gapok   | jabatan | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W |         | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | haha    | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | (^-.-^) | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  Scenario Outline: Add data Perubahan salary *TunJabatan*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok   | jabatan   | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 |   1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 6000000 | 500000,00 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  @salary_variasi
  Scenario Outline: Add data Perubahan salary *variasiData_tunJabatan*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok   | jabatan | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 |         |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | haha    |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | (^-.-^) |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  Scenario Outline: Add data Perubahan salary *TunKomunikasi*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok   | jabatan   | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 |   1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 6000000 | 	 1000000 |  500000,00 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  @salary_variasi
  Scenario Outline: Add data Perubahan salary *variasiData_tunKomunikasi*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok   | jabatan | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | 200000  |            |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | 200000  |     haha   |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | 200000  |    (^-.-^) |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  Scenario Outline: Add data Perubahan salary *TunTransportasi*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok   | jabatan   | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 |   1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 6000000 |   0100000 |     200000 |    500000,00 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  @salary_variasi
  Scenario Outline: Add data Perubahan salary *variasiData_tunTransportasi*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan

    Examples: 
      | nik                              | gapok   | jabatan | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | 200000  |     200000 |              | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | 200000  |     200000 |      haha    | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | 5000000 | 200000  |     200000 |    (^-.-^)   | Vaksin 1 | 2022-02-21 | Segera vaksin |

  