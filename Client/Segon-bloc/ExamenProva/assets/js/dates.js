export class Dates {
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new Dades();
    }
    return this._instance;
  }

  getDates = () => {
    moment.locale("ca");

    let d = moment();

    const result = [];

    for (let i = 0; i < 365; i++) {
      d = d.subtract(1, "days");
      result.push({
        value: d.format("YYYY-MM-DD"),
        label: d.format("D [de] MMMM [de] YYYY"),
      });
    }
    return result;
  };

  getSelectValues = (select) => {
    const options = select && select.options; // select.options is a collection of <option> elements
    return Array.from(options)
      .filter((opt) => opt.selected)
      .map((opt) => opt.value || opt.text);
  };
}
